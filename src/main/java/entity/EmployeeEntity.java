package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeEntity {
    @Id
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
