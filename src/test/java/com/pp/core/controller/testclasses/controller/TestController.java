package com.pp.core.controller.testclasses.controller;

import com.pp.core.controller.CreateController;
import com.pp.core.controller.DeleteController;
import com.pp.core.controller.GetByIdController;
import com.pp.core.controller.UpdateController;
import com.pp.core.controller.testclasses.controller.dto.CreateTestDto;
import com.pp.core.controller.testclasses.controller.dto.TestDto;
import com.pp.core.controller.testclasses.controller.dto.UpdateTestDto;
import com.pp.core.controller.testclasses.controller.mapper.FromCreateTestDtoMapper;
import com.pp.core.controller.testclasses.controller.mapper.FromUpdateTestDtoMapper;
import com.pp.core.controller.testclasses.controller.mapper.ToTestDtoMapper;
import com.pp.core.controller.testclasses.service.TestService;
import com.pp.core.controller.testclasses.service.record.InputTestRecord;
import com.pp.core.controller.testclasses.service.record.OutputTestRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
    implements CreateController<CreateTestDto, FromCreateTestDtoMapper, InputTestRecord, TestService, OutputTestRecord, ToTestDtoMapper, TestDto>,
               DeleteController<Long, TestService>,
               GetByIdController<Long, TestService, OutputTestRecord, ToTestDtoMapper, TestDto>,
               UpdateController<Long, UpdateTestDto, FromUpdateTestDtoMapper, InputTestRecord, TestService, OutputTestRecord, ToTestDtoMapper, TestDto> {

    private final TestService testService;
    private final FromCreateTestDtoMapper fromCreateTestDtoMapper;
    private final FromUpdateTestDtoMapper fromUpdateTestDtoMapper;
    private final ToTestDtoMapper toTestDtoMapper;

    public TestController(TestService testService,
                          FromCreateTestDtoMapper fromCreateTestDtoMapper,
                          FromUpdateTestDtoMapper fromUpdateTestDtoMapper,
                          ToTestDtoMapper toTestDtoMapper) {
        this.testService = testService;
        this.fromCreateTestDtoMapper = fromCreateTestDtoMapper;
        this.fromUpdateTestDtoMapper = fromUpdateTestDtoMapper;
        this.toTestDtoMapper = toTestDtoMapper;
    }

    @Override
    public TestService getService() {
        return testService;
    }

    @Override
    public FromUpdateTestDtoMapper getFromUpdateDtoMapper() {
        return fromUpdateTestDtoMapper;
    }

    @Override
    public FromCreateTestDtoMapper getFromCreateDtoMapper() {
        return fromCreateTestDtoMapper;
    }

    @Override
    public ToTestDtoMapper getToDtoMapper() {
        return toTestDtoMapper;
    }
}
