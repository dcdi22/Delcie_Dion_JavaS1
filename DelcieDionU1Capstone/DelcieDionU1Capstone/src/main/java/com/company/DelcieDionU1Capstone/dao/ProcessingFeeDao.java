package com.company.DelcieDionU1Capstone.dao;

import com.company.DelcieDionU1Capstone.dto.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {

    /*
    get
    get all
    add
    update
    delete
     */

    ProcessingFee getProcessingFee(String productType);

    List<ProcessingFee> getAllProcessingFees();

    ProcessingFee addProcessingFee(ProcessingFee processingFee);

    void updateProcessingFee(ProcessingFee processingFee);

    void deleteProcessingFee(String productType);

}
