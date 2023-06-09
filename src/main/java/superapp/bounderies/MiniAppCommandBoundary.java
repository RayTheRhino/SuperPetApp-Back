package superapp.bounderies;

import java.util.Date;
import java.util.Map;

public class MiniAppCommandBoundary {
    private CommandId commandId;
    private String command;
    private TargetObject targetObject;
    private Date invocationTimeStamp;
    private Map<String,Object> commandAttribute;
    private InvokedBy invokedBy;

    public InvokedBy getInvokedBy() {
        return invokedBy;
    }

    public void setInvokedBy(InvokedBy invokedBy) {
        this.invokedBy = invokedBy;
    }

    public MiniAppCommandBoundary() {
    }

    public CommandId getCommandId() {
        return commandId;
    }

    public void setCommandId(CommandId commandId) {
        this.commandId = commandId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public TargetObject getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(TargetObject targetObject) {
        this.targetObject = targetObject;
    }

    public Date getInvocationTimeStamp() {
        return invocationTimeStamp;
    }

    public void setInvocationTimeStamp(Date invocationTimeStamp) {
        this.invocationTimeStamp = invocationTimeStamp;
    }

    public Map<String, Object> getCommandAttribute() {
        return commandAttribute;
    }

    public void setCommandAttribute(Map<String, Object> commandAttribute) {
        this.commandAttribute = commandAttribute;
    }
}
