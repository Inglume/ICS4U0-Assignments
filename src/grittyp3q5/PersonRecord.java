package grittyp3q5;

import java.util.Calendar;

public class PersonRecord implements PersonalInfo {
  private Calendar creationDate;
  private int currentAge;

  public PersonRecord() {
    creationDate = Calendar.getInstance();
    currentAge = -1;
  }

  @Override
  public Calendar getFileCreationDate() {
    return creationDate;
  }

  @Override
  public int getCurrentAge(int birthYear) {
    currentAge = creationDate.get(Calendar.YEAR) - birthYear;
    return currentAge;
  }
}
