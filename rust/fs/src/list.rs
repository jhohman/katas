use clap::ArgMatches;
use std::path::Path;

pub fn list(matches: &ArgMatches) {
    let input: &str = matches.value_of("INPUT").unwrap();

    let path: &Path = Path::new(&input);

    match path.exists() {
        false => {
            println!("No directory or file: {}", path.display());
            ::std::process::exit(1);
        }
        true => list_path(path),
    }
}

fn list_path(path: &Path) {
    if path.is_file() {
        println!("{}", path.display());
    } else if path.is_dir() {
        print_directory(path);
    } else {
        println!("You probably don't have permission..");
    }
}

fn print_directory(path: &Path) {
    if let Ok(dir) = path.read_dir() {
        for entry in dir {
            if let Ok(entry) = entry {
                let metadata = entry.metadata();
                match metadata {
                    Ok(m) => {
                        println!(
                            "{0: <15} {1: <10} {2: <10}",
                            m.modified()
                                .expect("Can't get system time")
                                .elapsed()
                                .expect("failed to get duration")
                                .as_millis(),
                            m.len(),
                            entry.path().display()
                        );
                    }
                    Err(_) => println!(""),
                }
            }
        }
    } else {
        println!("You probably don't have permission..");
        ::std::process::exit(1);
    }
}
