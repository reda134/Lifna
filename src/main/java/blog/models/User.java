package blog.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "users")
public class User 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(length = 100)
	private String fullName;
	
	@OneToMany(mappedBy = "author")
	private Set<Post> posts = new HashSet<>();
	
	@Column(length = 60)
    private String password;
	
	@Column(length = 60)
    private String passwordConfirm;
	
/*	@ManyToMany(mappedBy = "role")
    private Set<Role> roles;*/


	public User() {
	}

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username='" + username + '\''  + '\''
				+ ", fullName='" + fullName + '\'' + '}';
	}
}