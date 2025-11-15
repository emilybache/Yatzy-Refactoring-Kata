module Yatzy.Test.Yatzy2Test

open Xunit
open ApprovalTests
open ApprovalTests.Reporters
open Yatzy2

[<UseReporter(typeof<DiffReporter>)>]
type YatzyApprovalTest() =
    [<Fact>]
    member _.``Todo``() =
        Approvals.VerifyAll([1; 2], fun t -> $"{t} => {t}");
