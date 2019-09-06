use crate::list::list;
use clap::ArgMatches;

pub fn parse_matches(matches: ArgMatches) {
    match matches.subcommand() {
        ("list", Some(m)) => list(m),
        _ => {}
    }
}
