package tms.servlet.service;

import org.junit.Test;
import tms.servlet.entity.Operation;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class OperationServiceImplTest {

    @Test
    public void calculate() {
        OperationService operationService = OperationServiceImpl.getInstance();
        double sum = operationService.calculate(2, 2, "sum");
        assertEquals(4, sum);
    }
}