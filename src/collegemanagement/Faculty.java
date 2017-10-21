/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemanagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Gaurav Sehar
 */
@Entity
@Table(name = "faculty", catalog = "Gaurav_Sehar_CMS", schema = "")
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f")
    , @NamedQuery(name = "Faculty.findByFacultyId", query = "SELECT f FROM Faculty f WHERE f.facultyId = :facultyId")
    , @NamedQuery(name = "Faculty.findByName", query = "SELECT f FROM Faculty f WHERE f.name = :name")
    , @NamedQuery(name = "Faculty.findByGender", query = "SELECT f FROM Faculty f WHERE f.gender = :gender")
    , @NamedQuery(name = "Faculty.findByDob", query = "SELECT f FROM Faculty f WHERE f.dob = :dob")
    , @NamedQuery(name = "Faculty.findByMOBILENo", query = "SELECT f FROM Faculty f WHERE f.mOBILENo = :mOBILENo")
    , @NamedQuery(name = "Faculty.findByEmail", query = "SELECT f FROM Faculty f WHERE f.email = :email")
    , @NamedQuery(name = "Faculty.findByAddress", query = "SELECT f FROM Faculty f WHERE f.address = :address")
    , @NamedQuery(name = "Faculty.findByPincode", query = "SELECT f FROM Faculty f WHERE f.pincode = :pincode")
    , @NamedQuery(name = "Faculty.findByDepartment", query = "SELECT f FROM Faculty f WHERE f.department = :department")
    , @NamedQuery(name = "Faculty.findByJoinDate", query = "SELECT f FROM Faculty f WHERE f.joinDate = :joinDate")
    , @NamedQuery(name = "Faculty.findByMName", query = "SELECT f FROM Faculty f WHERE f.mName = :mName")
    , @NamedQuery(name = "Faculty.findByMOccupation", query = "SELECT f FROM Faculty f WHERE f.mOccupation = :mOccupation")
    , @NamedQuery(name = "Faculty.findByMMOBILENo", query = "SELECT f FROM Faculty f WHERE f.mMOBILENo = :mMOBILENo")
    , @NamedQuery(name = "Faculty.findByFName", query = "SELECT f FROM Faculty f WHERE f.fName = :fName")
    , @NamedQuery(name = "Faculty.findByFOccupation", query = "SELECT f FROM Faculty f WHERE f.fOccupation = :fOccupation")
    , @NamedQuery(name = "Faculty.findByFMOBILENo", query = "SELECT f FROM Faculty f WHERE f.fMOBILENo = :fMOBILENo")
    , @NamedQuery(name = "Faculty.findByPercentageSecurePrevious", query = "SELECT f FROM Faculty f WHERE f.percentageSecurePrevious = :percentageSecurePrevious")
    , @NamedQuery(name = "Faculty.findByBloodGroup", query = "SELECT f FROM Faculty f WHERE f.bloodGroup = :bloodGroup")
    , @NamedQuery(name = "Faculty.findByNationality", query = "SELECT f FROM Faculty f WHERE f.nationality = :nationality")
    , @NamedQuery(name = "Faculty.findByMaritalStatus", query = "SELECT f FROM Faculty f WHERE f.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Faculty.findByCategory", query = "SELECT f FROM Faculty f WHERE f.category = :category")
    , @NamedQuery(name = "Faculty.findByHandicapped", query = "SELECT f FROM Faculty f WHERE f.handicapped = :handicapped")
    , @NamedQuery(name = "Faculty.findByUserImage", query = "SELECT f FROM Faculty f WHERE f.userImage = :userImage")
    , @NamedQuery(name = "Faculty.findByTitle", query = "SELECT f FROM Faculty f WHERE f.title = :title")
    , @NamedQuery(name = "Faculty.findByDesignation", query = "SELECT f FROM Faculty f WHERE f.designation = :designation")
    , @NamedQuery(name = "Faculty.findBySpeciality", query = "SELECT f FROM Faculty f WHERE f.speciality = :speciality")
    , @NamedQuery(name = "Faculty.findByExperience", query = "SELECT f FROM Faculty f WHERE f.experience = :experience")
    , @NamedQuery(name = "Faculty.findByHighestEducation", query = "SELECT f FROM Faculty f WHERE f.highestEducation = :highestEducation")
    , @NamedQuery(name = "Faculty.findByInterviewGiven", query = "SELECT f FROM Faculty f WHERE f.interviewGiven = :interviewGiven")})
public class Faculty implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FACULTY_ID")
    private Integer facultyId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "MOBILE_No")
    private String mOBILENo;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "PINCODE")
    private int pincode;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "JOIN_DATE")
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Basic(optional = false)
    @Column(name = "M_NAME")
    private String mName;
    @Basic(optional = false)
    @Column(name = "M_OCCUPATION")
    private String mOccupation;
    @Basic(optional = false)
    @Column(name = "M_MOBILE_No")
    private String mMOBILENo;
    @Basic(optional = false)
    @Column(name = "F_NAME")
    private String fName;
    @Basic(optional = false)
    @Column(name = "F_OCCUPATION")
    private String fOccupation;
    @Basic(optional = false)
    @Column(name = "F_MOBILE_No")
    private String fMOBILENo;
    @Basic(optional = false)
    @Column(name = "PERCENTAGE_SECURE_PREVIOUS")
    private int percentageSecurePrevious;
    @Basic(optional = false)
    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;
    @Basic(optional = false)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Basic(optional = false)
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private String category;
    @Basic(optional = false)
    @Column(name = "HANDICAPPED")
    private String handicapped;
    @Basic(optional = false)
    @Column(name = "USER_IMAGE")
    private String userImage;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "DESIGNATION")
    private String designation;
    @Basic(optional = false)
    @Column(name = "SPECIALITY")
    private String speciality;
    @Basic(optional = false)
    @Column(name = "EXPERIENCE")
    private int experience;
    @Basic(optional = false)
    @Column(name = "HIGHEST_EDUCATION")
    private String highestEducation;
    @Basic(optional = false)
    @Column(name = "INTERVIEW_GIVEN")
    private int interviewGiven;

    public Faculty() {
    }

    public Faculty(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public Faculty(Integer facultyId, String name, String gender, String mOBILENo, String email, String address, int pincode, String department, String mName, String mOccupation, String mMOBILENo, String fName, String fOccupation, String fMOBILENo, int percentageSecurePrevious, String bloodGroup, String nationality, String maritalStatus, String category, String handicapped, String userImage, String title, String designation, String speciality, int experience, String highestEducation, int interviewGiven) {
        this.facultyId = facultyId;
        this.name = name;
        this.gender = gender;
        this.mOBILENo = mOBILENo;
        this.email = email;
        this.address = address;
        this.pincode = pincode;
        this.department = department;
        this.mName = mName;
        this.mOccupation = mOccupation;
        this.mMOBILENo = mMOBILENo;
        this.fName = fName;
        this.fOccupation = fOccupation;
        this.fMOBILENo = fMOBILENo;
        this.percentageSecurePrevious = percentageSecurePrevious;
        this.bloodGroup = bloodGroup;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.category = category;
        this.handicapped = handicapped;
        this.userImage = userImage;
        this.title = title;
        this.designation = designation;
        this.speciality = speciality;
        this.experience = experience;
        this.highestEducation = highestEducation;
        this.interviewGiven = interviewGiven;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        Integer oldFacultyId = this.facultyId;
        this.facultyId = facultyId;
        changeSupport.firePropertyChange("facultyId", oldFacultyId, facultyId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        Date oldDob = this.dob;
        this.dob = dob;
        changeSupport.firePropertyChange("dob", oldDob, dob);
    }

    public String getMOBILENo() {
        return mOBILENo;
    }

    public void setMOBILENo(String mOBILENo) {
        String oldMOBILENo = this.mOBILENo;
        this.mOBILENo = mOBILENo;
        changeSupport.firePropertyChange("MOBILENo", oldMOBILENo, mOBILENo);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        int oldPincode = this.pincode;
        this.pincode = pincode;
        changeSupport.firePropertyChange("pincode", oldPincode, pincode);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        String oldDepartment = this.department;
        this.department = department;
        changeSupport.firePropertyChange("department", oldDepartment, department);
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        Date oldJoinDate = this.joinDate;
        this.joinDate = joinDate;
        changeSupport.firePropertyChange("joinDate", oldJoinDate, joinDate);
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        String oldMName = this.mName;
        this.mName = mName;
        changeSupport.firePropertyChange("MName", oldMName, mName);
    }

    public String getMOccupation() {
        return mOccupation;
    }

    public void setMOccupation(String mOccupation) {
        String oldMOccupation = this.mOccupation;
        this.mOccupation = mOccupation;
        changeSupport.firePropertyChange("MOccupation", oldMOccupation, mOccupation);
    }

    public String getMMOBILENo() {
        return mMOBILENo;
    }

    public void setMMOBILENo(String mMOBILENo) {
        String oldMMOBILENo = this.mMOBILENo;
        this.mMOBILENo = mMOBILENo;
        changeSupport.firePropertyChange("MMOBILENo", oldMMOBILENo, mMOBILENo);
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        String oldFName = this.fName;
        this.fName = fName;
        changeSupport.firePropertyChange("FName", oldFName, fName);
    }

    public String getFOccupation() {
        return fOccupation;
    }

    public void setFOccupation(String fOccupation) {
        String oldFOccupation = this.fOccupation;
        this.fOccupation = fOccupation;
        changeSupport.firePropertyChange("FOccupation", oldFOccupation, fOccupation);
    }

    public String getFMOBILENo() {
        return fMOBILENo;
    }

    public void setFMOBILENo(String fMOBILENo) {
        String oldFMOBILENo = this.fMOBILENo;
        this.fMOBILENo = fMOBILENo;
        changeSupport.firePropertyChange("FMOBILENo", oldFMOBILENo, fMOBILENo);
    }

    public int getPercentageSecurePrevious() {
        return percentageSecurePrevious;
    }

    public void setPercentageSecurePrevious(int percentageSecurePrevious) {
        int oldPercentageSecurePrevious = this.percentageSecurePrevious;
        this.percentageSecurePrevious = percentageSecurePrevious;
        changeSupport.firePropertyChange("percentageSecurePrevious", oldPercentageSecurePrevious, percentageSecurePrevious);
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        String oldBloodGroup = this.bloodGroup;
        this.bloodGroup = bloodGroup;
        changeSupport.firePropertyChange("bloodGroup", oldBloodGroup, bloodGroup);
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        String oldNationality = this.nationality;
        this.nationality = nationality;
        changeSupport.firePropertyChange("nationality", oldNationality, nationality);
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        String oldMaritalStatus = this.maritalStatus;
        this.maritalStatus = maritalStatus;
        changeSupport.firePropertyChange("maritalStatus", oldMaritalStatus, maritalStatus);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        String oldCategory = this.category;
        this.category = category;
        changeSupport.firePropertyChange("category", oldCategory, category);
    }

    public String getHandicapped() {
        return handicapped;
    }

    public void setHandicapped(String handicapped) {
        String oldHandicapped = this.handicapped;
        this.handicapped = handicapped;
        changeSupport.firePropertyChange("handicapped", oldHandicapped, handicapped);
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        String oldUserImage = this.userImage;
        this.userImage = userImage;
        changeSupport.firePropertyChange("userImage", oldUserImage, userImage);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        String oldDesignation = this.designation;
        this.designation = designation;
        changeSupport.firePropertyChange("designation", oldDesignation, designation);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        String oldSpeciality = this.speciality;
        this.speciality = speciality;
        changeSupport.firePropertyChange("speciality", oldSpeciality, speciality);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        int oldExperience = this.experience;
        this.experience = experience;
        changeSupport.firePropertyChange("experience", oldExperience, experience);
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        String oldHighestEducation = this.highestEducation;
        this.highestEducation = highestEducation;
        changeSupport.firePropertyChange("highestEducation", oldHighestEducation, highestEducation);
    }

    public int getInterviewGiven() {
        return interviewGiven;
    }

    public void setInterviewGiven(int interviewGiven) {
        int oldInterviewGiven = this.interviewGiven;
        this.interviewGiven = interviewGiven;
        changeSupport.firePropertyChange("interviewGiven", oldInterviewGiven, interviewGiven);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultyId != null ? facultyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.facultyId == null && other.facultyId != null) || (this.facultyId != null && !this.facultyId.equals(other.facultyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "collegemanagement.Faculty[ facultyId=" + facultyId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
