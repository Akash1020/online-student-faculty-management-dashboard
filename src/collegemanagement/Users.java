/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemanagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Gaurav Sehar
 */
@Entity
@Table(name = "users", catalog = "Gaurav_Sehar_CMS", schema = "")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUserid", query = "SELECT u FROM Users u WHERE u.userid = :userid")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByStudentsManagementPermission", query = "SELECT u FROM Users u WHERE u.studentsManagementPermission = :studentsManagementPermission")
    , @NamedQuery(name = "Users.findByFacultyManagementPermission", query = "SELECT u FROM Users u WHERE u.facultyManagementPermission = :facultyManagementPermission")
    , @NamedQuery(name = "Users.findByEmailManagementPermission", query = "SELECT u FROM Users u WHERE u.emailManagementPermission = :emailManagementPermission")
    , @NamedQuery(name = "Users.findByUsersManagementPermission", query = "SELECT u FROM Users u WHERE u.usersManagementPermission = :usersManagementPermission")})
public class Users implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "STUDENTS_MANAGEMENT_PERMISSION")
    private int studentsManagementPermission;
    @Basic(optional = false)
    @Column(name = "FACULTY_MANAGEMENT_PERMISSION")
    private int facultyManagementPermission;
    @Basic(optional = false)
    @Column(name = "EMAIL_MANAGEMENT_PERMISSION")
    private int emailManagementPermission;
    @Basic(optional = false)
    @Column(name = "USERS_MANAGEMENT_PERMISSION")
    private int usersManagementPermission;

    public Users() {
    }

    public Users(Integer userid) {
        this.userid = userid;
    }

    public Users(Integer userid, String username, String password, String email, int studentsManagementPermission, int facultyManagementPermission, int emailManagementPermission, int usersManagementPermission) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.studentsManagementPermission = studentsManagementPermission;
        this.facultyManagementPermission = facultyManagementPermission;
        this.emailManagementPermission = emailManagementPermission;
        this.usersManagementPermission = usersManagementPermission;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        Integer oldUserid = this.userid;
        this.userid = userid;
        changeSupport.firePropertyChange("userid", oldUserid, userid);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public int getStudentsManagementPermission() {
        return studentsManagementPermission;
    }

    public void setStudentsManagementPermission(int studentsManagementPermission) {
        int oldStudentsManagementPermission = this.studentsManagementPermission;
        this.studentsManagementPermission = studentsManagementPermission;
        changeSupport.firePropertyChange("studentsManagementPermission", oldStudentsManagementPermission, studentsManagementPermission);
    }

    public int getFacultyManagementPermission() {
        return facultyManagementPermission;
    }

    public void setFacultyManagementPermission(int facultyManagementPermission) {
        int oldFacultyManagementPermission = this.facultyManagementPermission;
        this.facultyManagementPermission = facultyManagementPermission;
        changeSupport.firePropertyChange("facultyManagementPermission", oldFacultyManagementPermission, facultyManagementPermission);
    }

    public int getEmailManagementPermission() {
        return emailManagementPermission;
    }

    public void setEmailManagementPermission(int emailManagementPermission) {
        int oldEmailManagementPermission = this.emailManagementPermission;
        this.emailManagementPermission = emailManagementPermission;
        changeSupport.firePropertyChange("emailManagementPermission", oldEmailManagementPermission, emailManagementPermission);
    }

    public int getUsersManagementPermission() {
        return usersManagementPermission;
    }

    public void setUsersManagementPermission(int usersManagementPermission) {
        int oldUsersManagementPermission = this.usersManagementPermission;
        this.usersManagementPermission = usersManagementPermission;
        changeSupport.firePropertyChange("usersManagementPermission", oldUsersManagementPermission, usersManagementPermission);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "collegemanagement.Users[ userid=" + userid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
