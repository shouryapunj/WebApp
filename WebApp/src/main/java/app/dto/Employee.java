package app.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class Employee {

    @NotNull
    @Size(max = 20)
    private String name;

    private String age;

    private String gender;

    @Pattern(regexp = "\\d{4}-\\d{4}-\\d{4}-\\d{4}")
    private String aadhar;

    @Pattern(regexp = "[0-9A-Za-z]{10}")
    private String pan;

    @Pattern(regexp = "\\d{10}")
    private String phoneNumber;

    public Employee() {
    }

    public Employee(String name, String age, String gender, String aadhar, String pan, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.aadhar = aadhar;
        this.pan = pan;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static interface NameStep {
        AgeStep withName(String name);
    }

    public static interface AgeStep {
        GenderStep withAge(String age);
    }

    public static interface GenderStep {
        AadharStep withGender(String gender);
    }

    public static interface AadharStep {
        PanStep withAadhar(String aadhar);
    }

    public static interface PanStep {
        PhoneNumberStep withPan(String pan);
    }

    public static interface PhoneNumberStep {
        BuildStep withPhoneNumber(String phoneNumber);
    }

    public static interface BuildStep {
        Employee build();
    }


    public static class Builder implements NameStep, AgeStep, GenderStep, AadharStep, PanStep, PhoneNumberStep, BuildStep {
        private String name;
        private String age;
        private String gender;
        private String aadhar;
        private String pan;
        private String phoneNumber;

        private Builder() {
        }

        public static NameStep employee() {
            return new Builder();
        }

        @Override
        public AgeStep withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public GenderStep withAge(String age) {
            this.age = age;
            return this;
        }

        @Override
        public AadharStep withGender(String gender) {
            this.gender = gender;
            return this;
        }

        @Override
        public PanStep withAadhar(String aadhar) {
            this.aadhar = aadhar;
            return this;
        }

        @Override
        public PhoneNumberStep withPan(String pan) {
            this.pan = pan;
            return this;
        }

        @Override
        public BuildStep withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public Employee build() {
            return new Employee(
                    this.name,
                    this.age,
                    this.gender,
                    this.aadhar,
                    this.pan,
                    this.phoneNumber
            );
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", pan='" + pan + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}