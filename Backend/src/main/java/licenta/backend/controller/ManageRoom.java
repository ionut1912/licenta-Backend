package licenta.backend.controller;


import licenta.backend.exception.ResourceNotFoundException;
import licenta.backend.helpers.RoomDetails;
import licenta.backend.model.Room;

import licenta.backend.model.RoomImages;
import licenta.backend.service.RoomImageService;
import licenta.backend.service.RoomReservationService;
import licenta.backend.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/room")
public class ManageRoom {
    @Resource
    RoomImageService roomImageService;
    @Resource
    RoomService roomService;
    @Resource
    RoomReservationService roomReservationService;


    @GetMapping
    public List<Room>  findAllRooms()
    {
        return roomService.findAll();
    }
    @GetMapping("/{checkin}/{checkout}")
    public List<RoomDetails> roomInfo(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date checkin, @PathVariable  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date checkout)
    {
        return  roomService.getInfo(checkin,checkout);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id)
    {
        Room room=roomService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Camera cu id-ul " +id+ " nu exista "));
      return  ResponseEntity.ok(room);
    }

    @GetMapping("/images")
    public List<RoomImages> fiindAll(){
        return  roomImageService.finAll();
    }
    @GetMapping("/images/{id}")
    public  List<RoomImages>findById(@PathVariable int id){
        return  roomImageService.findImageById(id);
    }
    @GetMapping("days/{checkin}/{checkout}")
    public int  getNrOfDays(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date checkin, @PathVariable  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date checkout ){
        return  roomReservationService.getNrOfdays(checkin,checkout);
    }
}
