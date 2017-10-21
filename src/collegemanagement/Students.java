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
@Table(name = "students", catalog = "Gaurav_Sehar_CMS", schema = "")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    , @NamedQuery(name = "Students.findByEnrollmentNo", query = "SELECT s FROM Students s WHERE s.enrollmentNo = :enrollmentNo")
    , @NamedQuery(name = "Students.findByName", query = "SELECT s FROM Students s WHERE s.name = :name")
    , @NamedQuery(name = "Students.findByGender", query = "SELECT s FROM Students s WHERE s.gender = :gender")
    , @NamedQuery(name = "Students.findByDob", query = "SELECT s FROM Students s WHERE s.dob = :dob")
    , @NamedQuery(name = "Students.findByMOBILENo", query = "SELECT s FROM Students s WHERE s.mOBILENo = :mOBILENo")
    , @NamedQuery(name = "Students.findByEmail", query = "SELECT s FROM Students s WHERE s.email = :email")
    , @NamedQuery(name = "Students.findByAddress", query = "SELECT s FROM Students s WHERE s.address = :address")
    , @NamedQuery(name = "Students.findByPincode", query = "SELECT s FROM Students s WHERE s.pincode = :pincode")
    , @NamedQuery(name = "Students.findByCourse", query = "SELECT s FROM Students s WHERE s.course = :course")
    , @NamedQuery(name = "Students.findByAdmnDate", query = "SELECT s FROM Students s WHERE s.admnDate = :admnDate")
    , @NamedQuery(name = "Students.findByMName", query = "SELECT s FROM Students s WHERE s.mName = :mName")
    , @NamedQuery(name = "Students.findByMOccupation", query = "SELECT s FROM Students s WHERE s.mOccupation = :mOccupation")
    , @NamedQuery(name = "Students.findByMMOBILENo", query = "SELECT s FROM Students s WHERE s.mMOBILENo = :mMOBILENo")
    , @NamedQuery(name = "Students.findByFName", query = "SELECT s FROM Students s WHERE s.fName = :fName")
    , @NamedQuery(name = "Students.findByFOccupation", query = "SELECT s FROM Students s WHERE s.fOccupation = :fOccupation")
    , @NamedQuery(name = "Students.findByFMOBILENo", query = "SELECT s FROM Students s WHERE s.fMOBILENo = :fMOBILENo")
    , @NamedQuery(name = "Students.findByPercentageSecurePrevious", query = "SELECT s FROM Students s WHERE s.percentageSecurePrevious = :percentageSecurePrevious")
    , @NamedQuery(name = "Students.findByBloodGroup", query = "SELECT s FROM Students s WHERE s.bloodGroup = :bloodGroup")
    , @NamedQuery(name = "Students.findByNationality", query = "SELECT s FROM Students s WHERE s.nationality = :nationality")
    , @NamedQuery(name = "Students.findByMaritalStatus", query = "SELECT s FROM Students s WHERE s.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Students.findByCategory", query = "SELECT s FROM Students s WHERE s.category = :category")
    , @NamedQuery(name = "Students.findByHandicapped", query = "SELECT s FROM Students s WHERE s.handicapped = :handicapped")
    , @NamedQuery(name = "Students.findByUserImage", query = "SELECT s FROM Students s WHERE s.userImage = :userImage")})
public class Students implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ENROLLMENT_NO")
    private Integer enrollmentNo;
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
    @Column(name = "COURSE")
    private String course;
    @Column(name = "ADMN_DATE")
    @Temporal(TemporalType.DATE)
    private Date admnDate;
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

    public Students() {
    }

    public Students(Integer enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public Students(Integer enrollmentNo, String name, String gender, String mOBILENo, String email, String address, int pincode, String course, String mName, String mOccupation, String mMOBILENo, String fName, String fOccupation, String fMOBILENo, int percentageSecurePrevious, String bloodGroup, String nationality, String maritalStatus, String category, String handicapped, String userImage) {
        this.enrollmentNo = enrollmentNo;
        this.name = name;
        this.gender = gender;
        this.mOBILENo = mOBILENo;
        this.email = email;
        this.address = address;
        this.pincode = pincode;
        this.course = course;
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
    }

    public Integer getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(Integer enrollmentNo) {
        Integer oldEnrollmentNo = this.enrollmentNo;
        this.enrollmentNo = enrollmentNo;
        changeSupport.firePropertyChange("enrollmentNo", oldEnrollmentNo, enrollmentNo);
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        String oldCourse = this.course;
        this.course = course;
        changeSupport.firePropertyChange("course", oldCourse, course);
    }

    public Date getAdmnDate() {
        return admnDate;
    }

    public void setAdmnDate(Date admnDate) {
        Date oldAdmnDate = this.admnDate;
        this.admnDate = admnDate;
        changeSupport.firePropertyChange("admnDate", oldAdmnDate, admnDate);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentNo != null ? enrollmentNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.enrollmentNo == null && other.enrollmentNo != null) || (this.enrollmentNo != null && !this.enrollmentNo.equals(other.enrollmentNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "collegemanagement.Students[ enrollmentNo=" + enrollmentNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
