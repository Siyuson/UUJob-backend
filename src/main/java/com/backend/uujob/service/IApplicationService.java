package com.backend.uujob.service;

import com.backend.uujob.controller.dto.ApplicationDTO;
import java.util.List;
public interface IApplicationService {
    List<ApplicationDTO> getApplication(Integer recruittableid);
}
