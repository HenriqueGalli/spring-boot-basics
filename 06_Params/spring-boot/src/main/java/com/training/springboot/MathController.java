package com.training.springboot;

import com.training.springboot.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.training.springboot.NumberHelper.convertToDouble;
import static com.training.springboot.NumberHelper.isNumeric;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberTwo) || !isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Selecionar um valor numérico");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double minus(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberTwo) || !isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Selecionar um valor numérico");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/times/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double times(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberTwo) || !isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Selecionar um valor numérico");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/divided/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divided(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberTwo) || !isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Selecionar um valor numérico");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne,
                          @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberTwo) || !isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Selecionar um valor numérico");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Selecionar um valor numérico");
        }
        return Math.sqrt(convertToDouble(numberOne));
    }
}
