package licenta.backend.model;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomid;

	@Column(name = "name")
	private String name;

	@Column(name = "roomtype")
	private String roomtype;

	@Column(name = "roomdetails")
    private  String roomdetails;
	@Column(name = "roomstatus")
	private String roomstatus;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "roomforimage")
	@JsonManagedReference("room")
	private List<RoomImages> images;
    @JsonIgnore
	@JsonManagedReference("room-roomReservation")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "room" )

	private List<RoomReservation> roomReservations;



	public long getRoomid() {
		return roomid;
	}

	public void setRoomid(long roomid) {
		this.roomid = roomid;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getStatus() {
		return roomstatus;
	}

	public void setStatus(String status) {
		this.roomstatus = status;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoomReservation> getRoomReservations() {
		return roomReservations;
	}

	public void setRoomReservations(List<RoomReservation> roomReservations) {
		this.roomReservations = roomReservations;
	}

	public String getRoomdetails() {
		return roomdetails;
	}

	public void setRoomdetails(String roomdetails) {
		this.roomdetails = roomdetails;
	}




	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}
@JsonManagedReference
	public List<RoomImages> getInages() {
		return images;
	}

	public void setInages(List<RoomImages> inages) {
		this.images = inages;
	}
}
