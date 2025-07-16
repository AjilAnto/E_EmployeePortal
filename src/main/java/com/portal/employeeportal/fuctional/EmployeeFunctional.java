package com.portal.employeeportal.fuctional;


public interface EmployeeFunctional {

    static Boolean isEmployeeNameValid(String employeeName) {
        return employeeName != null && employeeName.matches("^[A-Za-z\\s'-]{2,50}$")
                || employeeName.matches("^[a-zA-Z ]+$");
    }

    static Boolean isAgeValid(int ageInput) {
        if (ageInput != 0) {
            String ageString = String.valueOf(ageInput);
            return ageString.matches("^0?(19|[2-9][0-9])$");
        }
        else return Boolean.FALSE;
    }
}
