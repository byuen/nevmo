package com.capitalized.service;

import com.capitalized.model.Request;
import com.capitalized.model.User;
import com.capitalized.model.request.RequestRequest;
import com.capitalized.repository.RequestRepository;
import com.capitalized.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request createRequest(RequestRequest requestRequest) {
        Request request = new Request(requestRequest);
        return requestRepository.save(request);

    }
}
