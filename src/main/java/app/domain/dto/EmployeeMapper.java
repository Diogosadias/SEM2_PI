package app.domain.dto;

import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

    /**
     *
     * @author Tiago Rocha <1181445@isep.ipp.pt>
     */

    public class EmployeeMapper {

        public List toDto(List<Employee> list) {
            List<EmployeeDto> employeesDto = new ArrayList<>();
            for (Employee e : list) {
                    String role = e.getRole().getId();
                    String name = e.getName();
                    String address = e.getAddress();
                    long phoneNumber = e.getPhoneNumber();
                    String socCode = e.getSocCode();
                    EmployeeDto dto = new EmployeeDto(role,name,address,phoneNumber,socCode);
                    dto.setId(e.getEmployeeId());
                    if (role.equals(Constants.SPECIALIST_DOCTOR)) {
                        SpecialistDoctor s = (SpecialistDoctor) e;
                        dto.setDoctorIndexNumber(s.getDoctorIndexNumber());
                    }
                    employeesDto.add(dto);
            }
            return employeesDto;
        }
    }
