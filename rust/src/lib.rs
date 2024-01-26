pub type Roll = [u8; 5];
pub type Score = u8;

mod yatzy;
pub mod category {
    pub use crate::yatzy::*;
}

#[cfg(test)]
mod tests;
