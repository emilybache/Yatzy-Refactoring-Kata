module Yatzy.Test.Yatzy3Test

open Xunit
open ApprovalTests
open ApprovalTests.Reporters
open Yatzy.Yatzy3

[<UseReporter(typeof<DiffReporter>)>]
type YatzyApprovalTest() =
    [<Fact>]
    member _.``Todo``() =
        Approvals.VerifyAll([1; 2], fun t -> $"{t} => {t}");
