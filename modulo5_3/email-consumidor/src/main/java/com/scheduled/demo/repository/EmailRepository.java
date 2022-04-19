package com.scheduled.demo.repository;

import com.scheduled.demo.dto.EmailDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository {

    public static List<EmailDTO> received = new ArrayList<>();
}
