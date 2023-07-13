package com.nimna.possystemlts.dto.queryInterface;

import java.util.ArrayList;
import java.util.Date;

public interface OderDetailsInterface {
    String getCustomerName();
    String getCustomerAddress();
    ArrayList getContactNumber();

    //order
    double getTotal();

    Date getOrderDate();
}
