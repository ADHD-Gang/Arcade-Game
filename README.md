# Arcade Game
### CS 3443-01T, Dr. Arafat
Arcade Game is an application that allows you to play a selection of games such as Tic-Tac-Toe, Connect Four, and Hangman. It is a two-player experience meant to be shared between two users. It is designed for local play, meaning that both users should use the same system simultaneously for access and input. Features include:
- scorekeeping for each player, persistent between different games
- easy way to reset at the end of each game to start a new round
- easy access between different games; beginning a game doesn't disallow users from exiting and beginning a different game
### Functionality
- enter arcade
- select one of several different games (tic-tac-toe, hangman, connect four)
- scorekeeping for player 1 and player 2 for each victory gained
- back button to exit game
- mouse-click and keyboard input for playing games
- prompts to keep track of which player's turn it is, whether game was won, etc.
# Installing
> Note that this project was written in and built with Eclipse IDE; it is recommended to import these files into Eclipse and run the application there.
### Clone via GitHub Website
1. Click the green "code" button at the top of the repo page.
2. Select which option you would like to clone with. If you are unsure, choose the "HTTPS" option. Note: If you do not have SSH keys in your GitHub account, it will either prompt you to add a new public key to your account or will ask you to clone via HTTPS.
3. Select which option you would like to use for completing the cloning process. If you are unsure, choose "Download ZIP". A zip archive of the project will be downloaded to your system. From there, you may import the files into Eclipse and run the project.
### Clone via CLI
`git clone https://github.com/ADHD-Gang/Arcade-Game.git`
# Importing Project into Eclipse
1. Click "File" in menu.
2. Click "Open projects from File System".
3. At the top, near the box labeled "Import source:", on the right are two options: "Directory..." and "Archive...". If you have already unzipped the project, choose directory. If you have yet to, choose archive. Clicking either option will bring up a File Explorer window and prompt you to select the project files. Locate where they were downloaded to on your system (by default, the Downloads folder) and select the root folder (ArcadeGame) or the zip archive that you downloaded from previous steps.
4. Once you've selected the archive or the project files, the window with two columns labeled "Folder" and "Import as" will update with the archive/folder(s) it found. Ensure that ArcadeGame is selected. 
5. Click "Finish" at the bottom. ArcadeGame should now appear on the left of Eclipse in the Package Explorer as an open project.
# Running
Once you've completed the above steps, ArcadeGame will be present in Eclipse's Package Explorer. From the package explorer, you may right-click the project and click "run as" and then select "java application". You may also click the green "run main" button at the top of Eclipse. Either option will run the project and will begin ArcadeGame, prompting you to click to enter the arcade.
