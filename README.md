# Next Word Suggestion

This project provides a simplified version of Google's GBoard prediction of the next words when typing. It offers a basic text prediction functionality based on the words entered by the user.

## Overview

Text prediction is a common feature found in many modern input systems, including virtual keyboards on smartphones and tablets. This functionality helps users type faster by suggesting the next word or phrase based on the context of the input text.

In this project, was implemented a simple text prediction system in Java. The system takes input text and predicts the next word that the user is likely to type. It utilizes a dictionary-based approach, where the system learns from the input text to generate predictions.

## Features

- **Basic Text Prediction**: Given input text, the system predicts the next word that the user is likely to type.
- **Model Training**: The system trains a prediction model based on the input text provided by the user.
- **Customization**: The number of suggested words and other parameters can be customized based on user preferences.
- **Edge Case Handling**: Special characters, numbers, and input in other languages are handled gracefully to provide accurate predictions.

## Usage

To use the text prediction system, follow these steps:

1. Initialize the `TextPredictionProvider` class with the desired parameters.
2. Call the `getNextWordSuggestions` method with the input text to get the predicted words.
3. Customize the system parameters as needed based on user preferences.
4. Call the `trainModel` method to train the prediction model based on input text.
5. Optionally, you can call the `clearDictionary` method to reset the prediction dictionary.
