package uni.fmi.project.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import uni.fmi.project.Movie;
import uni.fmi.project.Reservation;

public class MakeReservationService {

	public static String makeReservation(Date userDate, Movie movie, Date movieDateAndTime, int numberOfTickets, List<String> seats) {
		
		if(movie.getMovieName() == null || movie.getMovieName().isEmpty()) {
			return "��������� ����������. ���� �������� ����";
		}
		if(movieDateAndTime == null) {
			return "��������� ����������. ���� �������� ������ � ��� �� ���������";
		}
		if(numberOfTickets == 0) {
			return "��������� ����������. ���� �������� ���� �� ��������";
		}
		if(seats == null || seats.isEmpty()) {
			return "��������� ����������. ���� �������� ����� � ������";
		}

        List<Reservation> reservations = getReservation();

        boolean isSeatTaken = reservations.parallelStream()
				.anyMatch(reservation-> reservation.getSeats().equals(seats)
						&& reservation.getDate().equals(movieDateAndTime));
        
        
        Date userTimeAfter60MinBeforeMovie = parseStringToDate("06-02-2021 17:30");
        //LocalTime userTimeBefore = LocalTime.parse("17:31");
        //String userTimeString = new SimpleDateFormat("H:mm").format(userDate);
        //LocalTime userTime = LocalTime.parse(userTimeString);
        //int isAfter = userTime.compareTo(userTimeBefore);
        
        if(isSeatTaken  && userDate.compareTo(userTimeAfter60MinBeforeMovie)>0) {
			return "��������� ����������. �� ������ �� ��������� ���������� ��-����� �� 60 ������ ����� �����. ��������� ����� �� �����";
		}else if(userDate.compareTo(userTimeAfter60MinBeforeMovie)>0) {
			return "��������� ����������. �� ������ �� ��������� ���������� ��-����� �� 60 ������ ����� �����";
		}
        
        if(isSeatTaken) {
        	
			return "��������� ����� �� �����";
		
    }
		
		return "������� ���������� ����������";
	}
	
  public static List<Reservation> getReservation(){
	    Movie movie = new Movie();
		movie.setMovieName("��������� �����");
		
		Date date = parseStringToDate("06-02-2021 18:30");
		
		List<String> seats = new ArrayList<String>();
		seats.add("11");
		seats.add("12");
		Reservation movieReservation = new Reservation(4586,date,movie,2,seats);

		List<Reservation> reservations = new ArrayList<Reservation>();
		reservations.add(movieReservation);

		return reservations;
		
	}
  
  public static Date parseStringToDate(String dateToBeParsed){
	    Date result = null;
	    try{
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyyy HH:mm");
	        result  = dateFormat.parse(dateToBeParsed);
	    }

	    catch(ParseException e){
	        e.printStackTrace();

	    }
	    return result ;
	}
}
