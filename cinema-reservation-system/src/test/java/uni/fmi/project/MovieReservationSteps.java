package uni.fmi.project;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.project.models.MovieReservationScreen;

public class MovieReservationSteps {

	MovieReservationScreen movieReservationScreen = new MovieReservationScreen();
	
	@Given("^����������� ������ ������ �� ���������� �� ���� �� \"([^\"]*)\"$")
	public void openReservationScreen(String userDateAndTime) throws Throwable {
		
		//parse userDateAndTime to Date type
		Date userDateAndTime2  = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(userDateAndTime);
		
        movieReservationScreen.setUserDateAndTime(userDateAndTime2);
	    movieReservationScreen.openScreen();
	}

	@Given("^������ ����� �� ����� \"([^\"]*)\"$")
	public void chooseMovie(String movieName) throws Throwable {
		
		Movie movie = new Movie();
	    movie.setMovieName(movieName);
		movieReservationScreen.setMovie(movie);
	}

	@When("^������ ������ � ���� �� ����������� \"([^\"]*)\"$")
	public void chooseTimeAndDate(String reservationDate) throws Throwable {
	    Date reservationDate2;
	    
	    if(reservationDate.isEmpty() || reservationDate == null) {
	    	reservationDate2 = null;
	    	movieReservationScreen.setDateAndTime(reservationDate2);
	    }else {
	    	reservationDate2 =new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(reservationDate);  
	 		movieReservationScreen.setDateAndTime(reservationDate2);
	    }
	    
	}

	@When("^������ ���� �� �������� \"([^\"]*)\"$")
	public void chooseNumberOfTickets(int numberOfTickets) throws Throwable {
		 movieReservationScreen.setNumberOfTickets(numberOfTickets);
	}

	@When("^������ ������� \"([^\"]*)\", \"([^\"]*)\"$")
	public void chooseSeat(String seat1, String seat2) throws Throwable {
		
		List<String> chosenSeats = new ArrayList<String>();
		chosenSeats.add(seat1);
		if(seat1.isEmpty() && seat2.isEmpty()) {
			chosenSeats = null;
		}else if(!seat2.isEmpty()) {
		chosenSeats.add(seat2);
		}
	    movieReservationScreen.setSeats(chosenSeats);
	}

	@When("^������� ����� ������ �� ����������\\.$")
	public void clickReservationButton() throws Throwable {
	    movieReservationScreen.clickReservationButton();
	}

	@Then("^����� ��������� \"([^\"]*)\"\\.$")
	public void receiveMessage(String expectedMessage) throws Throwable {
		 assertEquals(expectedMessage,movieReservationScreen.getReservationMessage());	
	}

}
