package orange.java.pl2.adventurecentral.users.guis.list.controllerExtend;

public class StageControllerExtend extends OnActionsControllerExtend {

    protected  StageControllerExtend() {
        this.addOnInitialize(resourceBundle -> {
            Platform.runLater(() -> {
                this.fxStage.setTitle(this.resourceBundle.getString("stage.title"));
            });
        });
    }
}
