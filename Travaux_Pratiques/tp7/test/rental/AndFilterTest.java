package rental ;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

import jdk.jfr.Timestamp;
import rental.*;

public class AndFilterTest {
    
    private AndFilter filter ;
    private Vehicle vehicle ;
    private Vehicle vehicle1 ;
    private VehicleFilter maxPriceFilter ;
    private VehicleFilter brandFilter ;
    

    @Before
    public void before() {
        this.filter = new AndFilter() ;
        this.vehicle = new Vehicle("Honda", "Full-Option", 2019, 5000) ;
        this.vehicle1 = new Vehicle("Toyota", "Full-Option", 2019, 65) ;
        this.maxPriceFilter = new MaxPriceFilter(100) ;
        this.brandFilter = new BrandFilter("Toyota") ;
    }

    @Test
    public void addFilterTest() {
        assertFalse(filter.getFilters().contains(brandFilter)) ;
        assertFalse(filter.getFilters().contains(maxPriceFilter)) ;
        filter.addFilter(brandFilter);
        filter.addFilter(maxPriceFilter) ;
        assertTrue(filter.getFilters().contains(brandFilter)) ;
        assertTrue(filter.getFilters().contains(maxPriceFilter)) ;
        
    }

    @Test
    public void acceptTest() {
        filter.addFilter(maxPriceFilter);
        assertFalse(filter.accept(vehicle)) ;
        assertTrue(filter.accept(vehicle1)) ;
        filter.addFilter(brandFilter);
        assertTrue(filter.accept(vehicle1)) ;
    }


    // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.AndFilterTest.class);
	}
}
