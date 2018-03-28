package org.whsrobotics.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by Larry on 6/2/17.
 */
public class ExampleCommand extends Command {
    /**
     * Creates a new command. The name of this command will be set to its class name.
     */
    public ExampleCommand() {
        super();
//        requires(SUBSYSTEM);
    }

    /**
     * The initialize method is called the first time this ExampleCommand is run after being started.
     */
    @Override
    protected void initialize() {
        super.initialize();
    }

    /**
     * The execute method is called repeatedly until this ExampleCommand either finishes or is canceled.
     */
    @Override
    protected void execute() {
        super.execute();
    }

    /**
     * Called when the command ended peacefully. This is where you may want to wrap up loose ends,
     * like shutting off a motor that was being used in the command.
     */
    @Override
    protected void end() {
        super.end();
    }

    /**
     * Called when the command ends because somebody called {@link edu.wpi.first.wpilibj.command.Command#cancel() cancel()} or
     * another command shared the same requirements as this one, and booted it out.
     * <p>
     * <p>This is where you may want to wrap up loose ends, like shutting off a motor that was being
     * used in the command.
     * <p>
     * <p>Generally, it is useful to simply call the {@link edu.wpi.first.wpilibj.command.Command#end() end()} method within this
     * method, as done here.
     */
    @Override
    protected void interrupted() {
        super.interrupted();
    }

    /**
     * Returns whether this command is finished. If it is, then the command will be removed and {@link
     * edu.wpi.first.wpilibj.command.Command#end() end()} will be called.
     * <p>
     * <p>It may be useful for a team to reference the {@link edu.wpi.first.wpilibj.command.Command#isTimedOut() isTimedOut()}
     * method for time-sensitive commands.
     * <p>
     * <p>Returning false will result in the command never ending automatically. It may still be
     * cancelled manually or interrupted by another command. Returning true will result in the
     * command executing once and finishing immediately. We recommend using {@link InstantCommand}
     * for this.
     *
     * @return whether this command is finished.
     * @see edu.wpi.first.wpilibj.command.Command#isTimedOut() isTimedOut()
     */
    @Override
    protected boolean isFinished() {
        return false;
    }
}
