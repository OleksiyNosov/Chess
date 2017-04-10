package Model.Commands;

public class CommandFactory {
    public static Command create(String rawCommand) {
        rawCommand = rawCommand.trim()
                               .replaceAll(" +", " ")
                               .toLowerCase();
        String[] rawCommandPieces = rawCommand.split(" ");

        switch (rawCommandPieces[0]) {
            case "new":
                return new CommandNew();
            case "clear":
                return new CommandClear();
            case "move":
                return new CommandMove(rawCommandPieces[1], rawCommandPieces[2]);
        }
        return null;
    }
}
