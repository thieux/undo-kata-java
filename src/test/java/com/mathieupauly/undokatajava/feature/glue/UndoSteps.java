package com.mathieupauly.undokatajava.feature.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UndoSteps {
    private boolean appendLogged;
    private String buffer;
    private String deleted;

    @Given("^no operation has been performed$")
    public void no_operation_has_been_performed() {
    }

    @Given("^append has been performed$")
    public void append_has_been_performed() {
        appendLogged = true;
    }

    @Given("^delete \"([^\"]*)\" has been performed$")
    public void delete_has_been_performed(String deleted) {
        this.deleted = deleted;
    }

    @Given("^the buffer printed \"([^\"]*)\"$")
    public void the_buffer_printed(String buffer) {
        this.buffer = buffer;
    }

    @When("^writer performs undo command$")
    public void writer_performs_undo_command() {
        buffer = undo(buffer);
    }

    @Then("^the buffer should print \"([^\"]*)\"$")
    public void the_buffer_should_print(String expectedBuffer) {
        assertThat(buffer).isEqualTo(expectedBuffer);
    }

    private String undo(String buffer) {
        if (deleted != null) {
            return buffer + deleted;
        }
        if (appendLogged) {
            return buffer.substring(0, buffer.length() - 1);
        }
        return buffer;
    }
}
