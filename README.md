# GameSearch Engine 🎮

A Java-based recommendation engine that helps users discover new games based on their Steam library and preferences. The engine uses fuzzy search algorithms and tag-based analysis to provide personalized game recommendations.

## Features 🌟

- **Steam Integration**: Automatically imports user's Steam library and playtime data
- **Smart Recommendations**: Uses tag-based analysis and playtime data to suggest relevant games
- **Fuzzy Search**: Intelligent game name matching using fuzzy search algorithms
- **GUI Interface**: Clean JavaFX-based user interface with:
  - Game browser with Steam store integration
  - Search functionality with autocomplete
  - Library management
  - Like/Dislike system for better recommendations
- **Adaptive Algorithm**: Adjusts recommendations based on user feedback
- **Playtime Analysis**: Considers time spent in games to weight preferences

## Technical Stack 📚

- **Core**: Java
- **GUI Framework**: JavaFX
- **External APIs**: 
  - Steam Web API
  - Apache Commons CSV
  - FuzzyWuzzy for string matching
- **Database**: CSV-based game dataset
- **Logging**: Apache Log4j

## Architecture 🏗️

The project is organized into several key components:

### Core Components
- `Database.java`: Manages game data and provides search functionality
- `Game.java`: Game object model with metadata and comparison methods
- `GameSearch.java`: Core recommendation engine logic
- `UserData.java`: User preference and library management

### UI Components
- `SearchApp.java`: Main application controller
- `GameWindow.java`: Game browser and recommendation interface
- `SearchWindow.java`: Search interface with autocomplete
- `LoginWindow.java`: Steam login handler

## Setup Instructions 🚀

1. Prerequisites:
   - Java JDK 11 or higher
   - Maven for dependency management
   - Steam API key for library integration

2. Configuration:
   ```bash
   # Clone the repository
   git clone https://github.com/yourusername/gamesearch-engine.git
   
   # Install dependencies
   mvn install
   
   # Set up Steam API key
   Add your Steam API key to GameSearch.java
   ```

3. Run the application:
   ```bash
   mvn javafx:run
   ```

## How It Works 🔍

1. **User Authentication**:
   - Users can either log in with their Steam ID or use the search interface
   - Steam login imports the user's game library and playtime data

2. **Recommendation Process**:
   - Analyzes user's game library and playtime
   - Creates a weighted tag profile based on played games
   - Suggests games with matching tags and high review scores
   - Adjusts recommendations based on likes/dislikes

3. **Search Algorithm**:
   - Uses fuzzy matching for flexible game name search
   - Considers popularity and review scores in results
   - Provides autocomplete suggestions from the game database

## Acknowledgments 👏

- Steam Web API for game data access
- Apache Commons and FuzzyWuzzy for core functionality
- JavaFX community for UI components
