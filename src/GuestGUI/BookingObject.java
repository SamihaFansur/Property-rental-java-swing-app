package GuestGUI;


import java.util.Date;
import java.time.Month;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;




public class BookingObject {
	
	
	DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	    private int booking_id;
	    private int property_id;
	    private int host_id;
	    private int guest_id;
	    private int review_id;
	    private boolean provisional;
	    private Double totalPrice;
	    private Date startDate;
	    private Date endDate;
	    /**
	     * @wbp.parser.entryPoint
	     */
	    public BookingObject(int booking_id, int property_id, int host_id, int guest_id, boolean provisional,Double totalPrice, Date startDate, Date endDate) {
	        this.review_id = review_id;
	        this.property_id = property_id ;
	        this.host_id = host_id;
	        this.guest_id = guest_id;
	        this.review_id = review_id;
	        this.provisional = provisional;
	        this.totalPrice = totalPrice;
	        this.startDate = startDate;
	        this.endDate = endDate;
	    }

	    public int getBooking_id() {
	        return booking_id;
	    }
	    public int getProperty_id() {
	        return property_id;
	    }
	    
	    public int getHost_id() {
	        return host_id;
	    }

	    public int getGuest_id() {
	        return guest_id;
	    }
	    public int getReview_id() {
	        return review_id;
	    }

	    public boolean getProvisional() {
	        return provisional;
	    }

	    public Double getTotalPrice() {
	        return totalPrice;
	    }

	    public Date getStartDate() {
	        return startDate;
	    }
	    public Date getEndDate() {
	        return endDate;
	    }
	    
}