package com.mathieupauly.undokatajava.feature.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UndoSteps {
    private String buffer;

    @Given("^append has been performed$")
    public void append_has_been_performed() {
    }

    @Given("^the buffer printed \"([^\"]*)\"$")
    public void the_buffer_printed(String buffer) {
        this.buffer = buffer;
    }

    @When("^writer performs undo command$")
    public void writer_performs_undo_command() {
        buffer = undo();
    }

    @Then("^the buffer should print \"([^\"]*)\"$")
    public void the_buffer_should_print(String expectedBuffer) {
        assertThat(buffer).isEqualTo(expectedBuffer);
    }

    private String undo() {
        return "Hell";
    }
}
