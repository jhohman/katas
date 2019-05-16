#[derive(Default)]
pub struct Logger {
    logs: Vec<String>,
}

pub struct FizzBuzz {}

impl FizzBuzz {
    fn fizz_buzz(logger: &mut Logger, range: usize) {
        for i in 1..=range {
            match (i%3, i%5) {
                (0,0) => logger.logs.push("fizzbuzz".to_string()),
                (0,_) => logger.logs.push("fizz".to_string()),
                (_,0) => logger.logs.push("buzz".to_string()),
                (_,_) => logger.logs.push(format!("{}", i).to_string()),
            }
        }
    }
}

fn main() {
    let mut logger: Logger = Default::default();

    FizzBuzz::fizz_buzz(&mut logger, 109);

    for log in logger.logs {
        println!("{}", log);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn prints_fizz_for_factors_of_three() {
        let mut logger: Logger = Default::default();

        FizzBuzz::fizz_buzz(&mut logger, 3);

        let expected: Vec<&str> = ["1", "2", "fizz"].to_vec();
        assert_eq!(expected, logger.logs);
    }

    #[test]
    fn prints_buzz_for_factors_of_five() {
        let mut logger: Logger = Default::default();

        FizzBuzz::fizz_buzz(&mut logger, 5);

        let expected: Vec<&str> = ["1", "2", "fizz", "4", "buzz"].to_vec();
        assert_eq!(expected, logger.logs);
    }

    #[test]
    fn prints_fizzbuzz_for_factors_of_three_and_five() {
        let mut logger: Logger = Default::default();

        FizzBuzz::fizz_buzz(&mut logger, 15);

        let expected: Vec<&str> = ["1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"].to_vec();
        assert_eq!(expected, logger.logs);
    }
}

