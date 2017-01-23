package blog.models;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VerificationToken
{
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private User user;

    private Date expiryDate;

    private boolean verified = false;

    public VerificationToken()
    {
	super();
    }

    public VerificationToken(String token, User user)
    {
	super();
	this.token = token;
	this.user = user;
	this.expiryDate = calculateExpiryDate(EXPIRATION);
	this.verified = false;
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes)
    {
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Timestamp(cal.getTime().getTime()));
	cal.add(Calendar.MINUTE, expiryTimeInMinutes);
	return new Date(cal.getTime().getTime());
    }

}