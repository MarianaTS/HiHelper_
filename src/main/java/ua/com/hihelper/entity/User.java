package ua.com.hihelper.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;
	private String password;
	private String email;
	private String phonenumber;
	private String country;
	private String city;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String description;

	@Enumerated
	private Role role;

	@OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
	private List<Appointment> appointment = new ArrayList<>();

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String pathImage;

	@OneToMany(mappedBy = "user")
	private List<Work> works = new ArrayList<>();

	@OneToMany(mappedBy = "sourceFollower")
	private List<Following> followers = new ArrayList<>();

	@OneToMany(mappedBy = "targetFollower")
	private List<Following> requestedFollowers = new ArrayList<>();

	@ManyToMany(mappedBy = "likes", fetch = FetchType.EAGER)
	private Set<Work> worksWhichLike = new HashSet<>();

	public Set<Work> getWorksWhichLike() {
		return worksWhichLike;
	}

	public void setWorksWhichLike(Set<Work> worksWhichLike) {
		this.worksWhichLike = worksWhichLike;
	}

	public List<Following> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Following> followers) {
		this.followers = followers;
	}

	public List<Following> getRequestedFollowers() {
		return requestedFollowers;
	}

	public void setRequestedFollowers(List<Following> requestedFollowers) {
		this.requestedFollowers = requestedFollowers;
	}

	public String getOriginUsername() {
		return username;
	}

	public User() {
	}

	public User(String username, String password, String email, String phoneNumber, String pathImage) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenumber = phoneNumber;

		this.pathImage = pathImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return String.valueOf(id);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phonenumber = phoneNumber;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public List<Work> getWorks() {
		return works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.name()));
		return authorities;

	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", phonenumber="
				+ phonenumber;
	}

}
