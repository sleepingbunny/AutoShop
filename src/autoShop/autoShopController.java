package autoShop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;

import java.text.DecimalFormat;

public class autoShopController {

    @FXML
    private CheckBox oilChange;

    @FXML
    private CheckBox lubeJob;

    @FXML
    private CheckBox tireRotation;

    @FXML
    private CheckBox wheelAlignment;

    @FXML
    private CheckBox brakeFluid;

    @FXML
    private CheckBox batteryChange;

    @FXML
    private RadioButton studentRadioButton;

    @FXML
    private RadioButton newCustomerRadioButton;

    @FXML
    private RadioButton noDiscountRadioButton;

    @FXML
    private Label oilPrice;

    @FXML
    private Label lubePrice;

    @FXML
    private Label tirePrice;

    @FXML
    private Label wheelPrice;

    @FXML
    private Label brakePrice;

    @FXML
    private Label batteryPrice;

    @FXML
    private Label studentDiscount;

    @FXML
    private Label newCustomerDiscount;

    @FXML
    private Label totalCharge;

    @FXML
    private Label totalBeforeDiscount;

    @FXML
    private Button totalButton;

    @FXML
    private Label totalPrice;
    
    @FXML
    private Label salesTax;
    
	private final double STUDENT_DISCOUNT_RATE = 0.1;
	private final double NEWCUSTOMER_DISCOUNT_RATE = 0.15;
	private final double SALES_TAX = 0.085;
	
    private double total = 0;    
    private double discount = 0;
    private double tax = 0;

    boolean oil, lube, tire, wheel, brake, battery;
    
    DecimalFormat fm = new DecimalFormat("##.00");
    
    public void priceReset() {  	
    	if(!(oilChange.isSelected())) {
    		oilPrice.setText("");
    		oil = false;
    	}
    	
    	if(!(lubeJob.isSelected())) {
    		lubePrice.setText("");
    		lube = false;
    	}
    	
    	if(!(tireRotation.isSelected())) {
    		tirePrice.setText("");
    		tire = false;
    	}
    	
    	if(!(wheelAlignment.isSelected())) {
    		wheelPrice.setText("");
    		wheel = false;
    	}
    	
    	if(!(brakeFluid.isSelected())) {
    		brakePrice.setText("");
    		brake = false;
    	}
    	
    	if(!(batteryChange.isSelected())) {
    		batteryPrice.setText("");
    		battery = false;
    	}
    	
    	total = 0;
    }    
    
    public void serviceListener(ActionEvent e) {
    	if(oilChange.isSelected()) {
    		oilPrice.setText("$ " + String.valueOf(ServiceList.OIL_CHANGE.getPrice()));
    		oil = true;
    	} 
    		  	
    	if(lubeJob.isSelected()) {
    		lubePrice.setText("$ " + String.valueOf(ServiceList.LUBE_JOB.getPrice())); 		
    		lube = true;
    	}	
    	
    	if(tireRotation.isSelected()) {
    		tirePrice.setText("$ " + String.valueOf(ServiceList.TIRE_ROTATION.getPrice()));  		
    		tire = true;
    	}	
    	
    	if(wheelAlignment.isSelected()) {
    		wheelPrice.setText("$ " + String.valueOf(ServiceList.WHEEL_ALLIGNMENT.getPrice()));
    		wheel = true;
    	}	
    	
    	if(brakeFluid.isSelected()) {
    		brakePrice.setText("$ " + String.valueOf(ServiceList.BRAKE_FLUID.getPrice()));
    		brake = true;
    	}
    	
    	if(batteryChange.isSelected()) {
    		batteryPrice.setText("$ " + String.valueOf(ServiceList.BATTERY_CHANGE.getPrice()));
    		battery = true;
    	}       	
    	
    	priceReset();
    }     
    
    public void calculateButtonListener(ActionEvent e) {
     	if(oil)
    		total += ServiceList.OIL_CHANGE.getPrice();
    	if(lube)
    		total += ServiceList.LUBE_JOB.getPrice();
    	if(tire)
    		total += ServiceList.TIRE_ROTATION.getPrice();
    	if(wheel)
    		total += ServiceList.WHEEL_ALLIGNMENT.getPrice();
    	if(brake)
    		total += ServiceList.BRAKE_FLUID.getPrice();
    	if(battery)
    		total += ServiceList.BATTERY_CHANGE.getPrice();
    	
    	if(studentRadioButton.isSelected()) {
    		discount = total * STUDENT_DISCOUNT_RATE;
    		studentDiscount.setText("$ (" + String.valueOf(fm.format(discount)) + ")");
    		newCustomerDiscount.setText("");
    	} else if(newCustomerRadioButton.isSelected()) {
    		discount = total * NEWCUSTOMER_DISCOUNT_RATE;
    		newCustomerDiscount.setText("$ (" + String.valueOf(fm.format(discount)) + ")");
    		studentDiscount.setText("");
    	} else
    		discount = 0;
    	
    	tax = SALES_TAX * (total - discount);
    	
    	salesTax.setText("$ " + String.valueOf(fm.format(tax)));
    	totalPrice.setText("$ " + String.valueOf(fm.format(total - discount + tax)));
    	
    	total = 0;
    }
}
