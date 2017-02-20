package CardGame.flow;

import CardGame.flow.core.CompositeModule;
import CardGame.flow.core.Module;
import CardGame.state.objects.Table;

/**
 * Created by stijn on 2/20/17.
 */
public class Game {

    private Table table;
    private CompositeModule module;

    public Game(Table table){
        this.table = table;
        this.module = new CompositeModule();
    }

    public void start() {
        while(!table.isFinished()){
            module.execute(this.table);
        }
    }

    public void addModule(Module module){
        this.module.addModule(module);
    }

    public Table getTable(){
        return table;
    }

}
