package com.mathieupauly.undokatajava.feature.glue;

import com.mathieupauly.undokatajava.UndoEditor;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UndoSteps {
    private final UndoEditor undoEditor = new UndoEditor();
    private String buffer;

    @Given("^no operation has been performed$")
    public void no_operation_has_been_performed() {
    }

    @Given("^append has been performed$")
    public void append_has_been_performed() {
        undoEditor.setAppendLogged(true);
    }

    @Given("^delete \"([^\"]*)\" has been performed$")
    public void delete_has_been_performed(String deleted) {
        undoEditor.setDeleted(deleted);
    }

    @Given("^the buffer printed \"([^\"]*)\"$")
    public void the_buffer_printed(String buffer) {
        this.buffer = buffer;
    }

    @When("^writer performs undo command$")
    public void writer_performs_undo_command() {
        buffer = undoEditor.undo(buffer);
    }

    @Then("^the buffer should print \"([^\"]*)\"$")
    public void the_buffer_should_print(String expectedBuffer) {
        assertThat(buffer).isEqualTo(expectedBuffer);
    }

}
