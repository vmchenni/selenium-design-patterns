package com.learnselenium.seleniumdesign.emirates;

import java.util.Map;

public interface FlightSearch {
    void search(Map<String, String> searchDetails);
    void setDatePicker(DatePicker datePicker);
}
