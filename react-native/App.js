import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { sprintf } from 'sprintf-js';

export default function App() {
  return (
    <View style={styles.container}>
      <Timer />
    </View>
  );
}

class Timer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      milliseconds: 0,
      seconds: 0,
      minutes: 0,
    }

    let startTime = new Date().getTime();
    setInterval(() => {
      let timeDifference = new Date().getTime() - startTime;
      let seconds = timeDifference / 1000;
      let minutes = seconds / 60;
      let leftoverSeconds = seconds % 60;
      let leftoverMillis = timeDifference % 1000 / 10;
      this.setState({
        milliseconds: leftoverMillis,
        seconds: leftoverSeconds,
        minutes: minutes,
      });
    }, 10);
  }

  render() {
    let { milliseconds, seconds, minutes } = this.state;
    let time = sprintf("%02d:%02d:%2d", minutes, seconds, milliseconds);
    return (
        <Text>{time}</Text>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  }
});
