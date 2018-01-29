package com.test;

import com.jfoenix.validation.NumberValidator;
import javafx.scene.control.TextInputControl;

public class MinNumberValidator extends NumberValidator {
    private int min;

    MinNumberValidator(int min) {
        this.min = min;
    }

    @Override
    protected void eval() {
        if (srcControl.get() instanceof TextInputControl) {
            TextInputControl textField = (TextInputControl) srcControl.get();
            try {
                if(textField.getText().isEmpty()) {
                    hasErrors.set(false);
                } else {
                    int result = Integer.parseInt(textField.getText());
                    if (result < min) {
                        message.set(result + " is < " + min);
                        hasErrors.set(true);
                    } else {
                        hasErrors.set(false);
                    }
                }
            } catch (Exception e) {
                message.set(textField.getText() + " is not a number");
                hasErrors.set(true);
            }
        }
    }
}
