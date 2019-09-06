use clap::{App, Arg, SubCommand};
use fs::command_parser::parse_matches;

fn main() {
    let matches = App::new("File System")
        .version("0.1")
        .about("A file system application")
        .subcommand(
            SubCommand::with_name("list")
                .about("Lists file system from input")
                .arg(Arg::with_name("INPUT").required(true)),
        )
        .get_matches();
    parse_matches(matches);
}
