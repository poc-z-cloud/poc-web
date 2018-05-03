package poc.web.bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import poc.domain.model.Car;
import poc.service.CarService;

@Controller
@Scope("view")
public class DtPaginatorView implements Serializable {
	private List<Car> cars;

	@Autowired
	private transient CarService carService;
	
	private Car selectedCar;

	private Car filterCar = new Car();
    
	private List<Car> filteredCars;

	private List<Car> selectedCars;

	@PostConstruct
	public void init() {
		cars = carService.createCars(10);
		filteredCars= retrieveFilteredCars(cars,filterCar);
	}

	private List<Car> retrieveFilteredCars(List<Car> cars2, Car filterCar) {
		List<Car> list = new ArrayList<Car>();
		
		if (StringUtils.isBlank(filterCar.getColor()) && StringUtils.isBlank(filterCar.getBrand()))
		{
			return cars2;
		}
		
		if (StringUtils.isBlank(filterCar.getColor()))
		{
			for(Car theCar: this.cars)
			{
				if (filterCar.getBrand().equalsIgnoreCase(theCar.getBrand()))
				{
					list.add(theCar);
				}
			}
			
		}
		
		if (StringUtils.isBlank(filterCar.getBrand()))
		{
			for(Car theCar: this.cars)
			{
				if (filterCar.getColor().equalsIgnoreCase(theCar.getColor()))
				{
					list.add(theCar);
				}
			}
			
		}

		for(Car theCar: this.cars)
		{
			if (filterCar.getColor().equalsIgnoreCase(theCar.getColor()) && filterCar.getBrand().equalsIgnoreCase(theCar.getBrand()))
			{
				list.add(theCar);
			}
		}

		return list;
	}

	public List<Car> getCars() {
		return this.getFilteredCars();
	}
	
	
	
    public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<Car> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(List<Car> selectedCars) {
		this.selectedCars = selectedCars;
	}

	
	
	public Car getFilterCar() {
		return filterCar;
	}

	public void setFilterCar(Car filterCar) {
		this.filterCar = filterCar;
	}
	
	

	public List<Car> getFilteredCars() {
		return filteredCars;
	}

	public void setFilteredCars(List<Car> filteredCars) {
		this.filteredCars = filteredCars;
	}

	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }	
	
    public void onCarChosen(SelectEvent event) {
        Car car = (Car) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "year:" + car.getYear());
        
//        for(Car theCar:this.getCars())
//        {
//        	if (theCar.getId().equalsIgnoreCase(car.getId()))
//        	{
//        		car.setYear(car.getYear());
//        		break;
//        	}
//        }
//         
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
    
    public void onOKListener(SelectEvent event) {
        Car car = (Car) event.getObject();
        
        System.out.println("year:" + this.selectedCar.getYear());
        
        for(Car theCar:this.cars)
        {
        	if (theCar.getId().equalsIgnoreCase(car.getId()))
        	{
        		car.setYear(car.getYear());
        		break;
        	}
        }
         
        this.filteredCars= this.retrieveFilteredCars(this.cars, this.filterCar);
    }    

    public void onOK() {
        Car car = this.selectedCar;
        
        System.out.println("year:" + this.selectedCar.getYear());
        boolean found=false;
        for(Car theCar:this.cars)
        {
        	if (theCar.getId().equalsIgnoreCase(car.getId()))
        	{
        		car.setYear(car.getYear());
        		found=true;
        		break;
        	}
        }
        
        if (!found)
        {
        	this.cars.add(car);
        }
         
        this.filteredCars= this.retrieveFilteredCars(this.cars, this.filterCar);

    }    
    
    public void onFilter() {
        this.filteredCars = this.retrieveFilteredCars(this.cars, this.filterCar);
         
    }    
    public void onDelete() {
        for(Car theCar:this.getSelectedCars())
        {
        	for(Car car:this.cars)
        	{
            	if (theCar.getId().equalsIgnoreCase(car.getId()))
            	{
            		this.cars.remove(car);
            		break;
            	}
        		
        	}
        }
        
        this.getSelectedCars().clear();
         
        this.filteredCars= this.retrieveFilteredCars(this.cars, this.filterCar);
    }    

    public void onAdd() {
    	this.selectedCar = this.carService.createNewCar();
    }    

    public void selectCarFromDialog(Car car) {
        RequestContext.getCurrentInstance().closeDialog(car);
    }    

	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		this.rewire(ois);
	}
	
	protected void rewire(ObjectInputStream ois)
            throws ClassNotFoundException, IOException {
		ServletContext servletContext = null;
        ois.defaultReadObject();
        servletContext = (ServletContext) FacesContext
                     .getCurrentInstance().getExternalContext().getContext();
        WebApplicationContextUtils
                     .getRequiredWebApplicationContext(servletContext)
                     .getAutowireCapableBeanFactory().autowireBean(this);
    }


}
