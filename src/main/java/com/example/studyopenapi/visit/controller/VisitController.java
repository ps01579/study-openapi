package com.example.studyopenapi.visit.controller;

import com.example.studyopenapi.visit.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
public class VisitController implements VisitApi{

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return VisitApi.super.getRequest();
    }

    @Override
    public ResponseEntity<VisitReservationDetailResponse> getVisitRequestDetail(VisitReservationDetailRequest visitReservationDetailRequest) {
        VisitReservationDetailResponse visitReservationDetailResponse = new VisitReservationDetailResponse();
        visitReservationDetailResponse
                .id(1)
                .name("박명길")
                .result("결과")
                .details("상세");
        
        return new ResponseEntity<>(visitReservationDetailResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitReservationListResponse> getVisitRequestList(VisitReservationListRequest visitReservationListRequest) {
        return VisitApi.super.getVisitRequestList(visitReservationListRequest);
    }

    /**
     * GET /visit/v1/helloWorld : Hello World
     * Hello World
     *
     * @return Hello World (status code 200)
     */
    @Override
    public ResponseEntity<String> helloWorld() {
        System.out.println(">>>>>>>>>>>>> " + applicationName);
        return new ResponseEntity<>("Hello World : " + applicationName, HttpStatus.OK);
    }

    /**
     * POST /visit/v1/saveVisitRequest : 출입예약 신청
     * 출입예약을 신청한다.
     *
     * @param visitReservationRequest (required)
     * @return A JSON array of user names (status code 200)
     */
    @Override
    public ResponseEntity<VisitReservationResponse> saveVisitRequest(VisitReservationRequest visitReservationRequest) {
        VisitReservationResponse visitReservationResponse = new VisitReservationResponse();
        visitReservationResponse
                .id(30)
                .name("박명길")
                .result("saveVisitRequest 결과");
        return new ResponseEntity<>(visitReservationResponse, HttpStatus.OK);
    }


}
