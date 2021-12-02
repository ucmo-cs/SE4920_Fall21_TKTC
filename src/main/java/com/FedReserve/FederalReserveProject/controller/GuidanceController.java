package com.FedReserve.FederalReserveProject.controller;

import com.FedReserve.FederalReserveProject.model.Book;
import com.FedReserve.FederalReserveProject.model.GuidanceEntity;
import com.FedReserve.FederalReserveProject.service.BookService;
import com.FedReserve.FederalReserveProject.service.GuidanceService;
import com.FedReserve.FederalReserveProject.vo.RequestGuidance;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class GuidanceController {

    private final BookService bookService;

    private final GuidanceService guidanceService;

    @Autowired
    public GuidanceController(BookService bookService, GuidanceService guidanceService) {
        this.bookService = bookService;
        this.guidanceService = guidanceService;
    }

    @CrossOrigin
    @PostMapping("/guidances")
    public ResponseEntity<?> save(@RequestBody RequestGuidance requestGuidances){


        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        GuidanceEntity guidanceEntity = mapper.map(requestGuidances, GuidanceEntity.class);

        System.out.println("title " + guidanceEntity.getPosterName());
        System.out.println("desc " + guidanceEntity.getGuidanceDesc());

        return new ResponseEntity<>(guidanceService.create(guidanceEntity), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/guidances")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(guidanceService.findAll(), HttpStatus.OK);
    }

    //@CrossOrigin
    @GetMapping("/guidances/{id}")
    public ResponseEntity<?> findAll(@PathVariable Integer id){
        System.out.println("findall in guidances/id");
        return new ResponseEntity<>(guidanceService.findGuidance(id), HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/guidances/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Book book){
        System.out.println("update in guidances/id");
        return new ResponseEntity<>(bookService.update(id, book), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/guidances/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id, @RequestBody Book book){
        System.out.println("deleteById in guidances/id");
        return new ResponseEntity<>(bookService.delete(id), HttpStatus.OK);
    }




}
