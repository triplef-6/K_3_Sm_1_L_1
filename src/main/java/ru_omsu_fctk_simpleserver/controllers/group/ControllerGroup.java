package ru_omsu_fctk_simpleserver.controllers.group;

import ru_omsu_fctk_simpleserver.controllers.ComonResponse;
import ru_omsu_fctk_simpleserver.controllers.ResponseEntity;
import ru_omsu_fctk_simpleserver.request.group.*;
import ru_omsu_fctk_simpleserver.response.group.*;
import ru_omsu_fctk_simpleserver.services.group.*;
import ru_omsu_fctk_simpleserver.validator.group.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerGroup {
    private AddStudentGroupsService addStudentGroupsService;
    private DeleteStudentGroupService deleteStudentGroupService;
    private EditStudentGroupsService editStudentGroupsService;
    private GetStudentGroupsService getStudentGroupsService;
    private GetStudentGroupByIdService getStudentGroupByIdService;
    private AddStudentGroupsValidator addStudentGroupsValidator;
    private EditStudentGroupsValidator editStudentGroupsValidator;
    private DeleteStudentGroupValidator deleteStudentGroupValidator;
    private GetStudentGroupByIdValidator getStudentGroupByIdValidator;

    public ResponseEntity<ComonResponse<AddStudentGroupsResponse>> addStudentGroups(AddStudentGroupsRequest request) {
        int status = 200;
        ComonResponse<AddStudentGroupsResponse> comonResponse;

        List<String> errors = addStudentGroupsValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(addStudentGroupsService.addStudentGroups(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, "Error", errors);
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors);
            //comonResponse = new ComonResponse<>(6, "Error", errors);
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    public ResponseEntity<ComonResponse<EditStudentGroupsResponse>> editStudentGroups(EditStudentGroupsRequest request) {
        int status = 200;
        ComonResponse<EditStudentGroupsResponse> comonResponse;

        List<String> errors = editStudentGroupsValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(editStudentGroupsService.editStudentGroups(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, "Error", errors); // своё сообщение об ошибке
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    public ResponseEntity<ComonResponse<DeleteStudentGroupResponse>> deleteStudentGroup(DeleteStudentGroupRequest request) {
        int status = 200;
        ComonResponse<DeleteStudentGroupResponse> comonResponse;

        List<String> errors = deleteStudentGroupValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(deleteStudentGroupService.deleteStudentGroup(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, "Error", errors); // своё сообщение об ошибке
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    public ResponseEntity<ComonResponse<GetStudentGroupByIdResponse>> getStudentGroupByIdGroup(GetStudentGroupByIdRequest request) {
        int status = 200;
        ComonResponse<GetStudentGroupByIdResponse> comonResponse;

        List<String> errors = getStudentGroupByIdValidator.validator(request);

        if (errors.isEmpty()) {
            try {
                comonResponse = new ComonResponse<>(getStudentGroupByIdService.getStudentGroupById(request));
            } catch (Exception exception) {
                status = 422;
                comonResponse = new ComonResponse<>(6, "Error", errors); // своё сообщение об ошибке
            }
        } else {
            status = 400;
            comonResponse = new ComonResponse<>(6, "Validation error", errors); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }

    private ResponseEntity<ComonResponse<GetStudentGroupsResponse>> getStudentGroups(GetStudentGroupsRequest request) {
        int status = 200;
        ComonResponse<GetStudentGroupsResponse> comonResponse;

        try {
            comonResponse = new ComonResponse<>(getStudentGroupsService.getStudentGroups(request));
        } catch (Exception exception) {
            status = 422;
            comonResponse = new ComonResponse<>(6, "Error", new ArrayList<>()); // своё сообщение об ошибке
        }

        return new ResponseEntity<>(comonResponse, status);
    }
}
