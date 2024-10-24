package dto;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private String empId;
    private String empName;
    private String empDob;
    private String empCnumber;
    private String empAddress;
    private String empAccNo;
    private String empBranch;
    private String empNic;
    private String empGender;


}
